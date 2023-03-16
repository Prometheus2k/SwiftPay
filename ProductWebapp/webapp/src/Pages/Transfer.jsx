import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import "./Transfer.css";
import arrow from "./arrow_right.svg"


const Transfer = () => {
    /*variable to store data about sender
    data stored is account number, amount, desciption(message),account number, swift code of the bank, bank name, branch name
    */
    const [form, setForm] = useState({
        account: "",
        amount: 0,
        description: "",
        recieverAccNumber: "",
        swiftCode: "",
        bankName: "",
        branchName: ""
    })

    const [recieverAccNumber, setRecieverAccNumber] = useState("")

    /*function to handle change in the input description and select field changed the values in the object according to the key defined*/
    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });

    }

    const handleRecieverAccount = (e) => {
        setRecieverAccNumber(e.target.value)
        
    }

    /* after submit shows the data stored in the form in alert and console */
    const submitButton = (e) => {
        e.preventDefault();
        console.log(recieverAccNumber, form.recieverAccNumber)
        if (recieverAccNumber !== form.recieverAccNumber) {
            alert("Provide correct Benefiatiary Account Number")
            throw console.error("Wrong confirm account number");
        } else {
            console.log(form);
            resetButton()
        }

    }

    /*after submiting the form the values in the form is reset */
    const resetButton = () => {
        setForm({
            accNumber: "",
            amount: 0,
            description: "",
            recieverAccNumber: "",
            swiftCode: "",
            bankName: "",
            branchName: ""
        });
        setRecieverAccNumber()
    }

    return (
        <div className='transfer'>
            <h1>Transfer</h1>
            <form>
                <div className='transferForm'>
                    <div className='transferForm_Left'>
                        <div className='row'>
                            <label>Account Number</label>
                            <input type="number" name="accNumber" onChange={handleChange} value={form.accNumber} required/>
                        </div>

                        <div className='row'>
                            <label>Amount</label>
                            <input type="number" name="amount" onChange={handleChange} value={form.amount} required/>

                        </div>
                        <div className='row'>
                            <label>Description</label>
                            <textarea type="text" name='description' onChange={handleChange} value={form.description} />
                        </div>
                    </div>

                    <img src={arrow} alt="right arrow" />

                    <div className='transferForm_Right'>
                        <div className='row'>
                            <label>Benefiatiary Account Number</label>
                            <input type="number" name="recieverAccNumber" onChange={handleChange} value={form.recieverAccNumber} required/>
                        </div>

                        <div className='row'>
                            <label>Confirm Benefiatiary Account Number</label>
                            <input type="number" name="recieverAccNumber" onChange={handleRecieverAccount} value={recieverAccNumber} required/>
                        </div>

                        <div className='row'>
                            <label>Swift Code</label>
                            <input type="text" name="swiftCode" onChange={handleChange} value={form.swiftCode} required/>
                        </div>

                        <div className='row'>
                            <label>Bank Name</label>
                            <input type="text" name="bankName" onChange={handleChange} value={form.bankName} required/>
                        </div>

                        <div className='row'>
                            <label>Bank branch name</label>
                            <input type="text" name="branchName" onChange={handleChange} value={form.branchName} required/>
                        </div>
                    </div>
                </div>
                <Button variant="primary" className='button' onClick={submitButton}>Initiate Transfer</Button>
            </form>
        </div>
    )
}

export default Transfer


