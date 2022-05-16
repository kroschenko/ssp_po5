import React from 'react';
import { Link } from 'react-router-dom';
import './mainMenu.scss';

const MainMenu = () => (
    <div className='main-menu'>
        <div className='main-menu-wrapper'>
            <Link to='/list' className='react-link'>
                <div className='faq menu-item'>
                    <span>Статьи</span>
                </div>
            </Link>
            <Link to={{
                    pathname:'/FAQ',
                    id: 'FAQ',
                }} className='react-link'>
                <div className='faq menu-item'>
                    <span>FAQ</span>
                </div>
            </Link>
            <div className='sign'>
                <Link to='/sign-up' className='react-link'>
                    <div className='sign-up menu-item'>
                        <span>Sign Up</span>
                    </div>
                </Link>
                <Link to='/sign-in' className='react-link'>
                    <div className='sign-in menu-item'>
                        <span>Sign In</span>
                    </div>
                </Link>
            </div>
        </div>
    </div>
);

export default MainMenu