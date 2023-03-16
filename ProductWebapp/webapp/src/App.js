import "./App.css";
import Login from "./components/Login/Login";
import SignUp from "./components/SignUp/SignUp";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar/SideBar";

import Transfer from "./Pages/Transfer";
import CustomPageTable from "./components/transactionHistory/AnotherTransactionHistory";
import TransactionHistory from "./components/transactionHistory/TransactionHistory";
import TDataGrid from "./components/transactionHistory/Trans3";

function App() {
  return (
    <div className="App">
      <TDataGrid />
      <TransactionHistory />
      <CustomPageTable />
    </div>
  );
}

export default App;
