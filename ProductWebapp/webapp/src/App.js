
import './App.css';
import Login from './components/Login/Login';
import SignUp from './components/SignUp/SignUp';
import { Routes, Route } from 'react-router-dom';
import SideBar from './components/SideBar/SideBar';

import Transfer from './Pages/Transfer';

function App() {
  return (
    <div className="App">
      <SideBar />
      <Routes>
        <Route path="/" element={<Transfer />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
}

export default App;
