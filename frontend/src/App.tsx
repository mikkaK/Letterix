import React from 'react';

import './App.css';

import { ActiveUserContextProvider } from './Contexts/ActiveUserContext';
import Router from './Router/Router';

function App() {
  return (
    <ActiveUserContextProvider>
        <header className="app-header">
            <div className="header-image"></div>
            <h1 className="app-name">Letterix</h1>
        </header>
        <div className="app-background">
            <Router />
        </div>
    </ActiveUserContextProvider>
  );
}

export default App;
