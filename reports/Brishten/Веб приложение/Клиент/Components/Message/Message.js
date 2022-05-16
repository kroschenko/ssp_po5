import React, { Component } from "react";
import { Table, Button } from "reactstrap";
import axios from "axios";
import '../Users/Users.scss';


export default class Message extends Component {
    constructor(props){
        super(props);
        this.state = {
            reports: [],
            login: this.props.login,
        }
    }

    componentDidMount() {
        this.getReports();
      }      
      getReports() {
      axios.get("http://localhost:8000/api/message/").then((response) => {
        if (response.status === 200) {
          if (this.state.login.slice(0, 5) === 'admin')
          {
            this.setState({
                reports: response.data ? response.data : [],
            });
          }
          else {
            this.setState({
              reports: response.data.filter(message => {return message.login === this.state.login}).map(
                message => {return message})
            })
          }
        }
        if (
        response.data.status === "failed" &&
        response.data.success === false
        ) {
        this.setState({
            noDataFound: response.data.message,
        });
        }
    });
    }

    deletMessage = (id) => {
      axios
        .delete(`http://localhost:8000/api/message/${id}/`)
        .then((response) => {
          this.getReports()
        })
        .catch((error) => {
          console.log(error);
        });
    }

  render() {
    localStorage.clear();
    const { noDataFound, reports} = this.state;
      let reportsDetails = [];
      let inc = 1
      if (reports.length) {
        reportsDetails = reports.map((report) => {
          return (
            <tr key={report.id}>
              <td>{inc++}</td>
              <td>{report.title}</td>
              <td>{report.date}</td>
              <td>{report.message}</td>
              <td>
                <Button
                  color="danger"
                  size="sm"
                  onClick={() => this.deletMessage(report.id)}
                >
                  Удалить
                </Button></td>
            </tr>
          );
        });
      }
   
    return (
      <div className="List">
        <div className='Table'>
      <div className="container mt-4 bg-white">
           <h3 className="font-weight-bold text-center text-danger">Сообщения</h3>
        <Table>
          <thead>
            <tr>
              <th>#</th>
              <th>Title</th>
              <th>Date</th>
              <th>Message</th>
              <th>Action</th>
            </tr>
          </thead>
          {reports.length === 0 ? (
            <tbody>
              <h3>{noDataFound}</h3>
            </tbody>
          ) : (
            <tbody>{reportsDetails}</tbody>
          )}
        </Table>
      </div>
      </div>
      </div>
    );
  }
}