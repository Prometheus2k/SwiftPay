import { Box } from "@mui/material";
import React, { useState } from "react";
import Sidenav from "../components/Sidenav";
import Navbar from "../components/Navbar";
import {
  TextField,
  Grid,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Button,
  Typography,
} from '@mui/material';
import arrow from "./arrow_right.svg"
import axios from "axios";
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';

export default function Transfer() {

  const [form, setForm] = useState({
    accNumber: "",
    amount: "",
    description: "",
    recieverAccNumber: "",
    swiftCode: "",
    bankName: "",
    branchName: ""
  })
  // <img src={arrow} alt="right arrow" height={140} width={140} />

  const [recieverAccNumber, setRecieverAccNumber] = useState("")

  const url = 'http://localhost:4000/transferData'

  const addExpenses = () => {
    axios.post(url, form).then(response => {
      console.log(response)
      console.log(response.status)
      if (response.status === 201) {
        alert("Transfer add added")
      }
    })
      .catch(error => console.log(error))
  }

  const handleChange = (e) => {
    e.preventDefault();
    setForm({ ...form, [e.target.name]: e.target.value });

  }

  const handleRecieverAccount = (e) => {
    setRecieverAccNumber(e.target.value)

  }

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(recieverAccNumber, form.recieverAccNumber)
    if (recieverAccNumber !== form.recieverAccNumber) {
      alert("Provide correct Benefiatiary Account Number")
      throw console.error("Wrong confirm account number");
    } else {
      console.log(form);
      resetButton()
    }
    // addExpenses()
  }

  const isFormValid = () => {
    return Object.values(form).every(value => value !== '');
  }

  const resetButton = () => {
    setForm({
      accNumber: "",
      amount: "",
      description: "",
      recieverAccNumber: "",
      swiftCode: "",
      bankName: "",
      branchName: ""
    });
    setRecieverAccNumber("")
  }


  return (
    <>
      <Navbar />
      <Box height={30} />
      <Box sx={{ display: "flex" }}>
        <Sidenav />
        <Box component="main" sx={{ flexGrow: 1, p: 3, height: "100vh", paddingTop: 15 }} style={{ backgroundColor: "#F0F0F0" }}>
          <form onSubmit={handleSubmit} style={{ backgroundColor: "#FFFFFF" }}>
            <Typography variant="h4" sx={{ padding: 2, textAlign: "center", size: "3em", fontWeight: "bold", color: "#005555" }}>Transfer</Typography>
            <Grid container alignItems='center' padding={5}>
              <Grid item xs={5} >
                <Typography variant="h6" sx={{ paddingBottom: 2 }}>Sender Information</Typography>
                <TextField
                  fullWidth
                  label="Account Number"
                  name="accNumber" onChange={handleChange} value={form.accNumber}
                  required
                  sx={{ paddingBottom: 2 }}
                />
                <TextField
                  fullWidth
                  label="Amount"
                  type="number"
                  name="amount"
                  onChange={handleChange} value={form.amount}
                  required
                  sx={{ paddingBottom: 2 }}
                />
                <TextField
                  fullWidth
                  label="Description"
                  name="description"
                  onChange={handleChange} value={form.description}
                  required
                  sx={{ paddingBottom: 2 }}
                />
              </Grid>
              <Grid item xs={2} >
                <Box textAlign='center' >
                  <ArrowCircleRightOutlinedIcon sx={{fontSize:130}} />
                </Box>
              </Grid>

              <Grid container item xs={5}>
                <Typography variant="h6" sx={{ paddingBottom: 2 }}>Beneficiary Information</Typography>
                <TextField
                  fullWidth
                  label="Account Number"
                  name="recieverAccNumber"
                  onChange={handleChange} value={form.recieverAccNumber}
                  sx={{ paddingBottom: 2 }}
                />
                <TextField
                  fullWidth
                  label="Confirm Beneficiary Account Number"
                  name="recieverAccNumber" onChange={handleRecieverAccount} value={recieverAccNumber}
                  required
                  sx={{ paddingBottom: 2 }}
                />
                <TextField
                  fullWidth
                  label="SWIFT Code"
                  name='swiftCode'
                  onChange={handleChange} value={form.swiftCode}
                  required
                  sx={{ paddingBottom: 2 }}
                />
                <FormControl fullWidth required sx={{ paddingBottom: 2 }}>
                  <InputLabel>Bank Name</InputLabel>
                  <Select
                    name='bankName'
                    onChange={handleChange} value={form.bankName}

                  >
                    <MenuItem value="SBI">SBI</MenuItem>
                    <MenuItem value="HDFC">HDFC</MenuItem>
                    <MenuItem value="American Express">American Express</MenuItem>
                    <MenuItem value="ICICI">ICICI</MenuItem>
                    <MenuItem value="Axis">Axis</MenuItem>
                  </Select>
                </FormControl>
                <TextField
                  fullWidth
                  label="Bank Branch Name"
                  name="branchName"
                  onChange={handleChange} value={form.branchName}
                  required
                  sx={{ paddingBottom: 2 }}
                />
              </Grid>
              <Grid item xs={12} >
                <Box textAlign='center'>
                  <Button variant="contained" style={{ backgroundColor: "#005555", width: 150, height: 50 }} type="submit" disabled={!isFormValid()}>
                    Submit
                  </Button>
                </Box>
              </Grid>
            </Grid>
          </form>
        </Box>
      </Box>
    </>
  );
}
