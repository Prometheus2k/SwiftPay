import "./App.css";
import { Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar/SideBar";
import Transfer from "./components/Pages/Transfer";

import UserProfile from "./components/userProfile/UserProfile";
import AddBankAccount from "./components/addbankaccount/AddBankAccount";
import TransactionHistory from "./components/transactionHistory/TransactionHistory";

function App() {
  return (
    <div className="App">
      <SideBar />
      <Routes>
        <Route path="/transfer" element={<Transfer />} />
        <Route path="/transactionhistory" element={<TransactionHistory />} />
        <Route path="/userprofile" element={<UserProfile />} />
        <Route path="/addbankacc" element={<AddBankAccount />} />
      </Routes>
    </div>
  );
}

export default App;
