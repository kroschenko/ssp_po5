import React from "react";
import axios from "axios";
import Articles from "./Article";
import './List.scss';


class ArticleList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      articles: [],
      list: this.props.list,
      login: this.props.login,
      authorized: this.props.authorized
    };
  }

  fetchArticles = () => {
    let type_list = this.state.list;
    if (typeof type_list === "undefined") {
      this.setState({list: "searchlist"})
    }
    let type = type_list
    if (type_list !== "checklist")
      type_list = "list"
    let Articles = []
    axios.get(`http://localhost:8000/api/${type_list}/`).then(res => {
      Articles = res.data;
      if (type === "my") {
        this.setState({
          articles: Articles.filter(article => {return article.login === this.state.login}).map(
            article => {return article})
        })
      }
      else {
        if (this.state.list === "checklist" && this.state.login.slice(0, 5) !== 'admin')
        {
          this.setState({
            articles: Articles.filter(article => {return article.login === this.state.login}).map(
              article => {return article})
          })
        }
        else if (this.state.list === "searchlist") {
          let text = this.props.location.text
          this.setState({
            articles: text !== "" ? Articles.filter(article => {return article.title.indexOf(text) + 1}).map(
              article => {return article}) : [],
              list: "list"
          })
        }
        else if (this.state.list === "recomlist") {
          axios.get("http://localhost:8000/api/follow/")
          .then((response) => {
            let followers = response.data
            let authors = followers.filter(entry => {return entry.follower === this.state.login}).map(
              entry => {return entry.author})
            var lastArticlesOfAuthors = []
            authors.forEach(author => {
              let entriesOfAuthor = Articles.filter(article => {return article.login === author}).map(
                article => {return article})
                lastArticlesOfAuthors.push(entriesOfAuthor.at(-1))
            });
            this.setState({
              articles: lastArticlesOfAuthors ? lastArticlesOfAuthors : [],
              list: "list"
            })
          })
        }
        else {
          this.setState({
            articles: Articles
          });
        }
      } 
    })
  }

  componentDidMount() {
    this.fetchArticles();
  }

  

  render() {
    return (
      <div className="List">
          <Articles login={this.state.login} authorized={this.state.authorized}
            data={this.state.articles} type_list={this.state.list}/> <br />
      </div>
    );
  }
}

export default ArticleList;