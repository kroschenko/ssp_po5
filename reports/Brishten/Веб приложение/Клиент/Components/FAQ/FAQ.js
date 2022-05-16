import React from 'react';
import { Link } from 'react-router-dom';
import './FAQ.scss';

const FAQ = (props) => {
    const type = props.location.id
    

    return (
        <div className="FAQ">
            <div className="FAQ-wrapper">
                <h1 className="title">FAQ</h1>
                { type === 'FAQ' ?
                    <div className="text">
                        Посетитель может просматривать и искать статьи. Чтобы иметь возможность 
                        самостоятельно создавать статьи и работать с ними, вам необходимо 
                        зарегистрироваться и войти в свою учетную запись.
                    </div>
                    :
                    <div className="text">
                        Чтобы осуществить экспорт или импорт нажмите кнопки в шапке страницы
                        "Выгрузить" и "Загрузить" соответственно. Учтите, что будут выгружены
                        только те статьи, которые прошли модерацию (проверку). Для того
                        чтобы статьи загрузить нужно сначала их выгрузить, обратно - так же. 
                    </div>
                }
                <Link to='/' className='react-link'>
                    <p>OK</p>
                </Link>
            </div>
        </div>
    )
}

export default FAQ;