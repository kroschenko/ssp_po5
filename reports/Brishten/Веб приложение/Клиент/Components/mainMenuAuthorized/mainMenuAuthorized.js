import React from 'react';
import { Link } from 'react-router-dom';
import './mainMenuAuthorized.scss';



const mainMenuAuthorized = (props) => {

    const SignOut = () => {
        props.setAuthStatus(false)
        props.setAuthLogin('')
    }

    return(
        <div className='main-menu'>
            <div className='main-menu-wrapper'>
                <Link to='/create' className='react-link'>
                    <div className='faq menu-item'>
                        <span>Создать статью</span>
                    </div>
                </Link>
                <Link to='/list' className='react-link'>
                    <div className='faq menu-item'>
                        <span>Статьи</span>
                    </div>
                </Link>
                <Link to='/mylist' className='react-link'>
                    <div className='faq menu-item'>
                        <span>Мои статьи</span>
                    </div>
                </Link>
                <Link to='/checklist' className='react-link'>
                    <div className='faq menu-item'>
                        <span>Отправленные</span>
                    </div>
                </Link>
                <Link to={{
                    pathname:'/FAQ',
                    id: 'Info',
                }} className='react-link'>
                    <div className='faq menu-item'>
                        <span>Экспорт/Импорт</span>
                    </div>
                </Link>
                <Link to='/recomlist' className='react-link'>
                    <div className='faq menu-item'>
                        <span>Рекомендуемое</span>
                    </div>
                </Link>
                { props.login.slice(0, 5) === "admin" &&
                    <Link to='/users' className='react-link'>
                        <div className='faq menu-item'>
                            <span>Пользователи</span>
                        </div>
                    </Link>
                }   
                <div className='react-link' onClick={SignOut}>
                    <div className='sign-out menu-item'>
                        <span>Sign Out</span>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default mainMenuAuthorized