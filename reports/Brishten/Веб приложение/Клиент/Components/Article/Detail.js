import React from "react";
import axios from "axios";
import { Redirect } from 'react-router';
import { Button, Card } from "antd";
import CustomForm from "./Form";
import './Detail.scss';


class ArticleDetail extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      article: {},
      redirect: false,
      path: '/list',
  };
}

  componentDidMount() {
    let type_list = this.props.location.list
    if (this.props.location.list === "all" || this.props.location.list === "my")
      type_list = "list"
    axios.get(`http://localhost:8000/api/${type_list}/${this.props.location.id}/`).then(res => {
      console.log(res.data);
      this.setState({
        article: res.data
      });
    });
  }

  handleDelete = event => {
    event.preventDefault();
    let type_list = this.props.location.list
    if (this.props.location.list === "my")
      type_list = "list"

    let URL = `http://localhost:8000/api/${type_list}/${this.props.location.id}/`
    if (this.props.location.list === "my")
    {
      URL = URL + "delete/"
    }
    axios.delete(URL)
    .then(res => {
      if (res.status === 204) {
        this.setState({ redirect: true });
        console.log("DELETE");
      }
    })
  };

  handleAdd = event => {
    event.preventDefault()

    axios.post("http://localhost:8000/api/create/", {
      login: this.state.article.login,
      title: this.state.article.title,
      content: this.state.article.content,
      image: this.state.article.image,
      description: this.state.article.description,
      kind: this.state.article.kind,
      avatar: this.state.article.avatar
    })
    .then(res => {
      if (res.status === 201) {
        console.log(res.data);
        this.handleDelete(event)
        this.handleReject(event)
      }
    })
    .catch(err => {
      console.log(err);
    })
  }

  handleReject = event => {
    event.preventDefault()
    let dateValue = new Date()
    let now = dateValue.getFullYear().toString() + "-" +
      dateValue.getMonth() + "-" + dateValue.getDate().toString();
    axios.post("http://localhost:8000/api/message/", {
      login: this.state.article.login,
      message: document.getElementById('message').value,
      date: now,
      title: this.state.article.title,
    })
    .then(res => {
      if (res.status === 201) {
        console.log(res.data, "OK");
        this.setState({ redirect: true });
      }
    })
    .catch(err => {
      console.log(err);
    })
  }

  render() {
    const redirect = this.state.redirect;
    if (redirect) {
      return <Redirect to='/list'/>
    }
    return (
      <div>
      <div className="Detail">
          <Card title={this.state.article.title}>
            <p> {this.state.article.content} </p>
          </Card>
        { this.props.location.list === "my" &&
        <div>
          <div className="Detail-wrapper">
            <CustomForm
              {...this.props}
              requestType="put"
              articleID={this.props.match.params.articleID}
              btnText="Update"
              login={this.state.article.login}
              data={this.state.article}
            />
          </div>
          <div className="Detail-button">
              <Button  type="danger" htmlType="submit" onClick={this.handleDelete}>
                Delete
              </Button>
          </div>
        </div>
        }
        { this.props.location.list ==="checklist" && this.props.location.login.slice(0, 5) === 'admin' &&
          <div className="Detail-wrapper">
              <Button type="primary" htmlType="submit" onClick={this.handleAdd}>
                Добавить
              </Button>
              <span className="Detail-wrapper"> </span>
              <Button type="dashed" htmlType="submit" onClick={this.handleReject}>
                Отклонить
              </Button>
              <div className="p-1">
                <label>Решение: </label> 
                <input name="message" className="w-50" id="message"/>
              </div>
          </div>
        }
        { this.props.location.list ==="checklist" && this.props.location.login === this.state.article.login &&
        <div className="user-button">
          <Button  type="danger" htmlType="submit" onClick={this.handleDelete}>
            Delete
          </Button>
        </div>
        }
      </div>
      </div>
    );
  }
}

export default ArticleDetail;