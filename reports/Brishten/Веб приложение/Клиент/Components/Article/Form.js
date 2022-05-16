import React from "react";
import { Form, Button, Space } from "antd";
import axios from "axios";
import { Redirect } from 'react-router';
import { Link } from 'react-router-dom';
import './Form.scss';

const FormItem = Form.Item;


class CustomForm extends React.Component {
  
  constructor(props) {
    super(props);

    this.state = {
      errors: {},
      redirect: false,
    };
  }

  handleValidation(Title, Content, Kind, Decription, Image) {
    let errors = {};
    let formIsValid = true;

    if (!Title || !Content || !Kind || !Decription || !Image) {
      formIsValid = false;
      errors["title"] = "Все поля должны быть заполнены";
    }
    else if (typeof Title !== "undefined") {
      if (!Title.match(/^[A-Z]/)) {
        formIsValid = false;
        errors["title"] = "Первая буква должна быть заглавной";
      }
      else if (!Title.match(/[a-zA-Z]{3,}/)) {
        formIsValid = false;
        errors["title"] = "Заголок должен иметь минимум три буквы";
      } 
    }

    else if (typeof Image !== "undefined") {
      if (!Image.match(/[A-Z]:(([\\/]{1})([\w]+))+(.)(png|jpg)$/)) {
        formIsValid = false;
        errors["image"] = "Укажите полный путь к формату .jpg или .png";
      }
    }


    this.setState({ errors: errors});
    return formIsValid;
  }

  handleFormSubmit = (values) => {

    const Title = document.getElementById('title').value
    const Content = document.getElementById('content').value;
    const Kind = document.getElementById('kind').value
    const Decription = document.getElementById('description').value
    const Image = document.getElementById('photo').value
    console.log(Title, Content, Kind, Decription, Image)

    if(!this.handleValidation(Title, Content, Kind, Decription, Image)) { return }

    const Login = this.props.login;
    const ArticleID = this.props.articleID;
    console.log("Image user: ", ArticleID)
    let type_list = "checklist"

    if (this.props.requestType === "post") {
      if (Login.slice(0, 5) === "admin") 
      {
        type_list = "create"
      }
        axios.post(`http://localhost:8000/api/${type_list}/`, {
          login: Login,
          title: Title,
          content: Content,
          image: Image,
          description: Decription,
          kind: Kind,
          avatar: ArticleID,
        })
        .then(res => {
          if (res.status === 201) {
            this.setState({ redirect: true });
            console.log(res.data);
          }
        })
        .catch(err => {
          console.log(err);
        })
    }
    else if (this.props.requestType === "put") {
      const Avatar = document.getElementById('avatar').value

      axios.put(`http://localhost:8000/api/list/${ArticleID}/update/`, {
        login: Login, 
        title: Title,
        content: Content,
        image: Image,
        description: Decription,
        kind: Kind,
        avatar: Avatar
      })
        .then(res => {
          if (res.status === 200) {
            this.setState({ redirect: true });
          }
        })
        .catch(err => {
          console.log(err);
        })
    }
  };

  render() {
    const redirect = this.state.redirect
    const buttonText = this.props.btnText
    var contentInput = {}

    if (redirect) {
      return <Redirect to='/list'/>
    }
    const data = this.props.data
    if (data) {
      contentInput['title'] = data.title
      contentInput['content'] = data.content
      contentInput['kind'] = data.kind
      contentInput['description'] = data.description
      contentInput['image'] = data.image
      contentInput['avatar'] = data.avatar
    }

    return (
      <div className="Form">
        <Form
          onFinish={(values) => this.handleFormSubmit(values)}
        >      
          <div>
            <label>Вводите заголовок здесь</label>
            <div>
              <div style={{ color: "red" }}> {this.state.errors["title"]}</div>
              <input id="title" name="title" defaultValue={contentInput['title']}/>
            </div>

            <label>Вид статьи</label>
            <div>
              <input id="kind" name="kind" defaultValue={contentInput['kind']}/>
            </div>

            <label>Краткое описание</label>
            <div>
              <input id="description" name="decription" defaultValue={contentInput['description']} className="w-100"/>
            </div>

            <label>Укажите адрес миниатюры</label>
            <div>
              <input id="photo" name="photo" defaultValue={contentInput['image']} className="w-100"/>
              <div style={{ color: "red" }}>{this.state.errors["photo"]}</div>
            </div>

            <label>Содержание</label>
            <span style={{ color: "red" }}> {this.state.errors["content"]}</span>
            <br></br>
            <textarea id="content" name="content" rows={5} defaultValue={contentInput['content']} cols={85}/>
            <input type="hidden" name="avatar" id="avatar" defaultValue={contentInput['avatar']}/>
          </div>
            <FormItem style={{padding: 10}}>
              <Space>
                <Button type="primary" htmlType="submit">
                  {buttonText}
                </Button>
                <Link to="/">
                  <Button type="dashed" htmlType="submit">
                    Назад
                  </Button>
                </Link>
              </Space>
            </FormItem>
        </Form>
      </div>
    );
  }
}

export default CustomForm;