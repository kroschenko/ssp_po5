
import React from 'react';
import { Link } from 'react-router-dom';
import './Header.scss';

class Header extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            currentDate: new Date(),
            text: "", 
            setTime: Date.now()
        }
      }

    componentDidMount() {
        const interval = setInterval(() => this.state.setTime, 5000);
        return () => {
            clearInterval(interval);
        };
    }

    updateInput = (evt) => {
        this.setState({
            text: evt.target.value
        })
    }

    render() {
    return (
        <header>
            <div className='header-wrapper'>
                    <div className='logo'>
                        <Link to='/' className='react-link'>
                            <p>Меню</p>
                        </Link>
                        {this.props.authorized &&
                        <div className='logo'>
                            <Link to='/message' className='react-link'>
                                <p>Сообщения</p>
                            </Link>
                            <span className='info'>
                                Действия:  
                            </span>
                            <Link className='react-link' to={{
                                    pathname: '/unload',
                                    type: 'unload',
                                    login: this.props.login
                                }}>
                                <p>Выгрузить</p>
                            </Link>
                            <Link className='react-link' to={{
                                    pathname: '/unload',
                                    type: 'load',
                                    login: this.props.login
                                }}>
                                <p>Загрузить</p>
                            </Link>
                        </div>
                        }
                        <span className='form'>
                            <input 
                                className='input' 
                                name='text' 
                                placeholder='Найти статью'
                                value={this.state.text}
                                onChange={evt => this.updateInput(evt)}
                                />
                            
                            <Link 
                                className='button' 
                                to={{
                                    pathname:`/searchlist`,
                                    text: this.state.text,
                                    list: "searchlist",
                                    login: this.props.login
                                }}>
                                Поиск
                            </Link>
                        </span>   
                    </div>
                <div className='info'>
                    <p className='login'>{this.props.authorized ? this.props.login : 'Guest'}</p>
                    <p className='time'>{('0' + this.state.currentDate.getHours()).substr(-2) + ':' + ('0' + this.state.currentDate.getMinutes()).substr(-2)}</p>
                </div>
            </div>
        </header>
    );
    }
}



export default Header