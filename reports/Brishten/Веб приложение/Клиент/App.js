import { Switch, Route} from 'react-router-dom';
import React from 'react';
import Header from './Components/Header/Header';
import SignUp from './Components/signUp/signUp';
import SignIn from './Components/signIn/signIn';
import MainMenu from './Components/mainMenu/mainMenu';
import MainMenuAuthorized from './Components/mainMenuAuthorized/mainMenuAuthorized';
import FAQ from './Components/FAQ/FAQ';
import List from './Components/Article/List';
import Create from './Components/Article/Create';
import Detail from './Components/Article/Detail';
import Unloading from './Components/Unloading/Unloading';
import Users from './Components/Users/Users';
import Message from './Components/Message/Message';
import 'antd/dist/antd.css';


const App = (props) => {
  console.log(props)
  return (
      <div className="App"> 
          <Header 
            login={props.login} 
            authorized={props.authorized} 
          />
          <Switch>
            <Route exact path='/' component={() => props.authorized ? <MainMenuAuthorized
              setAuthLogin={props.setAuthLogin} 
              setAuthStatus={props.setAuthStatus}
              login={props.login}
            />
            :
            <MainMenu/>
            }
            />
            <Route exact path='/sign-up' component={() => 
              <SignUp  
                setAuthLogin={props.setAuthLogin} 
                setAuthStatus={props.setAuthStatus}
              />} 
            />
            <Route exact path='/sign-in' component={() => 
              <SignIn
                setAuthLogin={props.setAuthLogin} 
                setAuthStatus={props.setAuthStatus}
              />}  
            />
            <Route exact path='/create' component={() => 
              <Create
                 login={props.login}
              />}
            />
            <Route exact path='/list' component={() =>
              <List
                  list="all"
                  login={props.login}
                  authorized={props.authorized}
                />}
              />
            <Route exact path='/mylist' component={() =>
              <List 
                  list="my"
                  login={props.login}
                  authorized={props.authorized}
                />}
              />
            <Route exact path='/checklist' component={() =>
              <List
                  list="checklist"
                  login={props.login}
                  authorized={props.authorized}
                />}
              />
            <Route exact path='/recomlist' component={() =>
              <List
                  list="recomlist"
                  login={props.login}
                  authorized={props.authorized}
                />}
              />
            <Route exact path='/message' component={() =>
              <Message
                  login={props.login}
              />}
              />
            <Route exact path='/searchlist' component={List}/>
            <Route exact path='/users' component={Users}/>
            <Route exact path='/unload' component={Unloading}/>
            <Route exact path="/list/:articleID/" component={Detail}/>
            <Route exact path='/FAQ' component={FAQ} />
          </Switch>
      </div>
  );
}

export default App