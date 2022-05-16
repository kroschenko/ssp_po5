import React from "react";
import CustomForm from "./Form";
import axios from "axios";
import './Create.scss';

class CreateArticle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          image: null,
          login: this.props.login,
      };
    }

    componentDidMount() {
        this.getUserImage()
    }

    getUserImage () {
        axios.get(`http://localhost:8000/api/users/`)
        .then((response) => {
            const Users = response.data
            let log = this.props.login
            let img = ""
            Users.forEach(function (user) {
                if (user.login === log) {
                    img = user.image                  
                }
            });
            this.setState({image: img})
        })
    }

    render() {
    return (
        <div className="Create">
            <h2> Create an article </h2>
            <CustomForm 
                requestType="post" 
                articleID={this.state.image} 
                btnText="Отправить" 
                login={this.props.login}
                data={null}
            />
        </div>
    )}
};

export default CreateArticle;