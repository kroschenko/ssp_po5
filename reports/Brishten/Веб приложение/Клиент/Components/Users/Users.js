import React, { Component } from "react";
import { Table, Button } from "reactstrap";
import axios from "axios";

export default class Users extends Component {
    constructor(props){
        super(props);
        this.state = {
            users: [],
            usersban: [],
            dictUsersban: {}
        }
    }

    componentDidMount() {
        this.getUsers();
        this.getUsersBan();
      }      
    getUsers() {
    axios.get("http://localhost:8000/api/users/").then((response) => {
        if (response.status === 200) {
        this.setState({
            users: response.data ? response.data : [],
        });
        }
      });
      }

    getUsersBan() {
      axios.get("http://localhost:8000/api/userban/")
      .then((response) => {
        if (response.status === 200) {
          console.log("usersban: ", response.data);
          this.setState({
              usersban: response.data ? response.data : [],
          });
          this.checkUserBan(response.data)
        }
      })
      .catch((error) => {
        console.log(error);
      })
    }

    banUser = (Login, DateValue) => {
      let dateValue = new Date(DateValue);
      let dateNow = new Date()
      if (dateValue.toString() === "Invalid Date")
      {
        alert("Выберите до какой даты");
      }
      else if (dateValue < dateNow)
      {
        alert("Дата > Сегодня");
      }
      else
      {
        let Date = dateValue.getFullYear().toString() + "-" +
        dateValue.getMonth() + "-" + dateValue.getDate().toString();
        axios.post(`http://localhost:8000/api/userban/`, {
          login: Login,
          date: Date,
        })
        .then((response) => {
          if (response.status === 201) {
            alert("Пользователь забанен");
            this.getUsersBan();
          }
        })
      }
    }

    checkUserBan(usersban) {
      let dateValue = {};
      let usersLogin = {} 
      let dateNow = new Date();
      let dateBan, year, month, day;
      usersban.map((user) => {dateValue[user.id] = user.date.split('-')});
      usersban.map((user) => {usersLogin[user.id] = user.login});
      for (let id in dateValue) {
        year = Number(dateValue[id][0])
        month = Number(dateValue[id][1])
        day = Number(dateValue[id][2])
        dateBan = new Date(year, month, day)
        if (dateNow > dateBan) {
          console.log("check", id)
          this.razbanUser(id, usersLogin[id])
        }
      }
    }

    razbanUser = (id, login) => {
      console.log("razban:", id)
      axios
        .delete(`http://localhost:8000/api/userban/${id}/`)
        .then((response) => {
          alert("Пользователь разбанен");
          delete this.state.dictUsersban[login]
          this.getUsersBan();
        })
    }
    
    deletUser = (id, login) => {
      axios
        .delete(`http://localhost:8000/api/users/${id}/`)
        .then((response) => {
          this.getUsers();
          if (Object.values(this.state.dictUsersban).includes(this.state.dictUsersban[login])) {
            this.razbanUser(this.state.dictUsersban[login], login);
          }
          else {
            this.getUsersBan();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    }

  render() {

    const { noDataFound, users} = this.state;
      let usersDetails = [];
      let dict = {};
      let usersBan = this.state.dictUsersban
      this.state.usersban.map((userban) => usersBan[userban.login] = userban.id);
      this.state.usersban.map((userban) => dict[userban.login] = userban.date);
      let inc = 1;
      if (users.length) {
        usersDetails = users.filter(user => {return user.login.slice(0, 5) !== "admin"}).map((user) => {
          return (
              <tr key={user.id}>
              <td>{inc++}</td>
              <td>{user.login}</td>
              <td>
                  {Object.keys(usersBan).includes(user.login) ?
                    <Button
                      color="primary"
                      size="sm"
                      onClick={() => this.razbanUser(usersBan[user.login], user.login)}
                    >
                      Разбан  
                    </Button>
                      :
                    <Button
                      color="warning"
                      size="sm"
                      onClick={() => this.banUser(user.login, document.getElementById(user.id).value)}
                    >
                      Бан  
                    </Button>
                  }
              </td>
              <td>
                  {Object.keys(usersBan).includes(user.login) ?
                    <span>
                     Бан до {dict[user.login]}
                    </span>
                    :
                    <span> 
                      <input id={user.id} type="date"/>             
                    </span>
                  }
              </td>
              <td>
                <Button
                  color="danger"
                  size="sm"
                  onClick={() => this.deletUser(user.id, user.login)}
                >
                  Удалить
                </Button>
              </td>
            </tr>
          );
        });
      }
   
    return (
      <div className="List">
        <div className='Table'>
          <div className="container mt-4 bg-white">
            <h3 className="font-weight-bold text-center text-danger">Пользователи</h3>
          <Table>
            <thead>
              <tr>
                <th>#</th>
                <th>Login</th>
                <th>Blocking</th>
                <th>Date</th>
                <th>Deleting</th>
              </tr>
            </thead>
            {users.length === 0 ? (
              <tbody>
                {noDataFound}
              </tbody>
            ) : (
              <tbody>{usersDetails}</tbody>
            )}
          </Table>
          </div>
        </div>
      </div>
    );
  }
}