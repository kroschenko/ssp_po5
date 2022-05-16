import React from "react";
import axios from "axios";
import { Link } from 'react-router-dom';
import './Unloading.scss';


class Unloading extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      articles: [],
      login: this.props.location.login,
      flag: false
    };
  }

  Export = () => {
    axios.get(`http://localhost:8000/api/export/`, {
        params: {
          login: this.state.login
        }
      }).then(res => {
        console.log(res.status);
        if(res.status === 200)
        {
          this.setState({flag: true, articles: res.data})
        }  
      }).catch(err => {console.log(err)});
  }

  Import = () => {
    axios.get(`http://localhost:8000/api/import/`, {
        params: {
          login: this.state.login
        }
      }).then(res => {
          if(res.data.Flag === 'OK')
          {
            this.setState({flag: true});
          }
      }).catch(err => {console.log(err)});
  }

  componentDidMount() {
    const type = this.props.location.type;

    if(this.state.login === 'admin')
    {
      if (type === 'unload')
      {
        axios.get(`http://localhost:8000/api/dump/`);
        this.setState({flag: true});
      }
      else if(type === 'load')
      {
        axios.get(`http://localhost:8000/api/load/`);
      }
    }
    else if(type === 'unload') 
    {
      this.Export();
    }
    else if(type === 'load')
    {
      this.Import();
    }
  }

  render() {
    return (
    <div className="Unload">
          <div className="Unload-wrapper">
              <h1 className="title">Информация</h1>
              {this.props.location.type === 'unload' && this.state.login !== 'admin' && (this.state.flag ?
                <div className="text">
                    Выгружено {this.state.articles.length} статей
                </div>
                : 
                <div className="text">
                    Ваши статьи уже выгружены!
                </div>)
              }
              {this.props.location.type === 'load' && this.state.login !== 'admin' && (this.state.flag ?
                <div className='text'>
                    Загрузка статей завершена
                </div>
                :
                <div className="text">
                    Сначала выгрузите статьи!
                </div>)
              }
              {this.state.login === 'admin' && (this.state.flag ?
                <div className='text'>
                  Выгрузка завершена
                </div>
                :
                <div className='text'>
                  Восстановление завершено
                </div>
                )
              } 
          </div>
          <Link to='/' className='react-link'>
                <p>OK</p>
            </Link>
      </div>
    );
  }
}

export default Unloading;

