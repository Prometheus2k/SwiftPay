import "./App.css";
import { Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar/SideBar";
import Transfer from "./Pages/Transfer";
import BasicExampleDataGrid from "./components/transactionHistory/Trans3";
import UserProfile from "./components/userProfile/UserProfile";
import AddBankAccount from "./components/addbankaccount/AddBankAccount";

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
