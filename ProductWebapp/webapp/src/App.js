import "./App.css";
import Login from "./components/Login/Login";
import SignUp from "./components/SignUp/SignUp";
import { Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar/SideBar";

import Transfer from "./Pages/Transfer";
import TransactionHistory from "./components/transactionHistory/TransactionHistory";
import UserProfile from "./components/userProfile/UserProfile";
import AddBankAccount from "./components/addbankaccount/AddBankAccount";

function App() {
  return (
    <div className="App">
      <SideBar />
      <Routes>
        <Route path="/" element={<Transfer />} />
        <Route path="/transactionhistory" element={<TransactionHistory />} />
        <Route path="/userprofile" element={<UserProfile />} />
        <Route path="/addbankacc" element={<AddBankAccount />} />
      </Routes>
    </div>
  );
}

export default App;
