import React from "react";
import { List } from "antd";
import { SmileOutlined } from '@ant-design/icons';
import { Link } from 'react-router-dom';
import axios from "axios";
import "./Article.scss";

const IconText = ({ type, text }) => (
  <span>
    <SmileOutlined
      type={type}
      style={{
        marginRight: 8
      }}
    />
    {text}
  </span>
);

class Articles extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      followers: [],
    }
  }

  componentDidMount() {
    this.getData()
  }

  getData() {
    axios.get("http://localhost:8000/api/follow/").then((response) => {
      this.setState({followers: response.data})
    })
  }

  follow = (author, follower) => {
    console.log(follower)
    axios.post(`http://localhost:8000/api/follow/`, {
      author: author,
      follower: follower,
    }).then((response) => {
      this.getData()
    })
  }

  unfollow = (author, follower) => {
    axios.get("http://localhost:8000/api/follow/")
    .then((response) => {
      let data = response.data
      let id = data.filter(entry => {
        return (entry.author === author && entry.follower === follower)}).map(
        entry => {return entry.id})
        console.log(id[0])
        axios.delete(`http://localhost:8000/api/follow/${id[0]}/`)
        .then((response) => {
          this.getData()
        })
    })
  }

  render() {
  return (
    <List
      itemLayout="vertical"
      size="large"
      pagination={{
        onChange: page => {
          console.log(page)
        },
        pageSize: 2
      }}
      dataSource={this.props.data}
      renderItem={item => (
        <List.Item
          key={item.title}
          actions={[
            <IconText type="star-o" text="156" />,
            <IconText type="like-o" text="156" />,
            <IconText type="message" text="2" />,
          ]}
          extra={
            <img
              width={272}
              alt="logo"
              src={item.image}
            />
          }
        >
          <List.Item.Meta
            avatar={<img src={item.avatar} alt="avatar" className="avatar"/>}
            title={<Link to={{
              pathname:`/list/${item.id}/`,
              id: item.id,
              list: this.props.type_list,
              login: this.props.login,
            }}> {item.title} </Link>}
            description={"Раздел: " + item.kind}
          />
          { 
            item.login === this.props.login || !this.props.authorized ? 
            <p className="user">{'@' + item.login}</p> 
            :
            ( this.state.followers.filter(entry => {
                return entry.author === item.login && entry.follower === this.props.login})
                .map(entry => {return entry.follower})
                .includes(this.props.login) ?
              <span className="follow">
                <span className="user">{'@' + item.login}</span> 
                <button className="but" onClick={() => this.unfollow(item.login, this.props.login)}>Отписаться</button>
              </span> 
              :
              <span className="follow">
                <span className="user">{'@' + item.login}</span> 
                <button className="but" onClick={() => this.follow(item.login, this.props.login)}>Подписаться</button>
              </span>
            )
          }
          
          <p className="content">{'Описание: ' + item.description}</p>
        </List.Item>
      )}
    />
  );
  }
};

export default Articles;