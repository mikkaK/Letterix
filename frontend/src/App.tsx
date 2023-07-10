import React from 'react';

import './App.css';

import { ActiveUserContextProvider } from './Contexts/ActiveUserContext';
import Router from './Router/Router';

function App() {
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
