
import './App.css';
import Login from './components/Login/Login';
import SignUp from './components/SignUp/SignUp';
import { BrowserRouter, Routes,Route } from 'react-router-dom';
import SideBar from './components/SideBar/SideBar';

import Transfer from './Pages/Transfer';

function App() {
  return (
    <div className="App">
      <Transfer />
      
    </div>
  );
}

export default App;
