import React from 'react';

import './App.css';

import { ActiveUserContextProvider } from './Contexts/ActiveUserContext';
import Router from './Router/Router';
import {useNavigate} from "react-router-dom";

function App() {
    const navigate = useNavigate();
  return (
    <ActiveUserContextProvider>
        <header className="app-header">
            <div className="header-image"></div>
            <a href={"/"} className="app-name">Letterix</a>
        </header>
        <div className="app-background">
            <Router />
        </div>
    </ActiveUserContextProvider>
  );
}

export default App;
