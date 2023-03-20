import React, { useState, useEffect } from "react";
import "./addbankaccount.css";
import Button from "react-bootstrap/Button";
export default function AddBankAccount() {
  const [form, setForm] = useState({
    bankName: "",
    AccNumber: "",
    confAccNumber: "",
    branchName: "",
    accountType: "",
    ifscCode: "",
    balance: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const submitButton = (e) => {
    e.preventDefault();
    console.log(form.AccNumber);
    resetButton();
  };

  /*after submiting the form the values in the form is reset */
  const resetButton = () => {
    setForm({
      bankName: "",
      AccNumber: "",
      confAccNumber: "",
      branchName: "",
      accountType: "",
      ifscCode: "",
      balance: "",
    });
  };
  return (
    <div className="addacc">
      <h1>Add Bank Details</h1>
      <form>
        <div className="addAccForm">
          <div className="addAccForm_Left">
            <div className="row">
              <label>Bank Name</label>
              <input
                type="text"
                name="bankName"
                onChange={handleChange}
                value={form.bankName}
                required
              />
            </div>
            <div className="row">
              <label>Account Number</label>
              <input
                type="number"
                name="AccNumber"
                onChange={handleChange}
                value={form.AccNumber}
                required
              />
            </div>
            <div className="row">
              <label>Confirm Account Number</label>
              <input
                type="number"
                name="confAccNumber"
                onChange={handleChange}
                value={form.confAccNumber}
                required
              />
            </div>
          </div>

          <div className="addAccForm_Right">
            <div className="row">
              <label>Bank Branch</label>
              <input
                type="text"
                name="branchName"
                onChange={handleChange}
                value={form.branchName}
                required
              />
            </div>
            <div className="row">
              <label>Account Type</label>
              <select
                defaultValue="Savings"
                name="account"
                onChange={handleChange}
                value={form.accountType}
              >
                <option hidden value="Choose...">
                  Choose...
                </option>
                <option value="Savings">Savings</option>
                <option value="Current">Current</option>
                <option value="Fixed Deposit">Fixed Deposit</option>
              </select>
            </div>

            <div className="row">
              <label>IFSC Code</label>
              <input
                type="text"
                name="ifscCode"
                onChange={handleChange}
                value={form.ifscCode}
                required
              />
            </div>
          </div>
        </div>
        <div className="row row-last">
          <label>Initial balance</label>
          <input
            type="number"
            name="balance"
            onChange={handleChange}
            value={form.balance}
            required
          />
        </div>
        <Button variant="primary" onClick={submitButton}>
          SAVE ACCOUNT
        </Button>
      </form>
    </div>
  );
}
