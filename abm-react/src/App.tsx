import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Header } from './components/Header/Header';
import 'bootstrap/dist/css/bootstrap.css';
import { AppRouter } from './routers/AppRouter';
import { BrowserRouter } from 'react-router-dom';
function App() {
  return (
    <>
      <BrowserRouter basename="/">
        <div style={{minHeight:"100vh"}}>
          <Header></Header>
          <AppRouter></AppRouter>
        </div>
      </BrowserRouter>
    </>
  );
}
 
export default App;
