import "./App.css";
import Login from "./components/Login/Login";
import SignUp from "./components/SignUp/SignUp";
<<<<<<< HEAD
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar/SideBar";

import Transfer from "./Pages/Transfer";
import CustomPageTable from "./components/transactionHistory/AnotherTransactionHistory";
import TransactionHistory from "./components/transactionHistory/TransactionHistory";
import TDataGrid from "./components/transactionHistory/Trans3";
=======
import { Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar/SideBar";

import Transfer from "./Pages/Transfer";
import TransactionHistory from "./components/transactionHistory/TransactionHistory";
import UserProfile from "./components/userProfile/UserProfile";
import AddBankAccount from "./components/addbankaccount/AddBankAccount";
>>>>>>> 40d00a2223f9a9e9ade8b5f18852fa43322d204c

function App() {
  return (
    <div className="App">
<<<<<<< HEAD
      <TDataGrid />
      <TransactionHistory />
      <CustomPageTable />
=======
      <SideBar />
      <Routes>
        <Route path="/" element={<Transfer />} />
        <Route path="/transactionhistory" element={<TransactionHistory />} />
        <Route path="/userprofile" element={<UserProfile />} />
        <Route path="/addbankacc" element={<AddBankAccount />} />
      </Routes>
>>>>>>> 40d00a2223f9a9e9ade8b5f18852fa43322d204c
    </div>
  );
}

export default App;
