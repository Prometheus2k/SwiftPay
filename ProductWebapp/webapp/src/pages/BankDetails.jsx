import React, { useEffect, useState } from "react";
import Sidenav from "../components/Sidenav";
import Navbar from "../components/Navbar";
import "../styles/Dashboard.css";
import "../styles/Bankdetails.css";
import {
  Card,
  CardContent,
  CardHeader,
  Grid,
  Typography,
  Box,
  Divider,
} from "@mui/material";
import axios from "axios";

// const banks = [
//   {
//     value: "SBI",
//   },
//   {
//     value: "HDFC",
//   },
//   {
//     value: "ICICI",
//   },
//   {
//     value: "JPY",
//   },
// ];

const url = `https://7a64-171-78-178-71.in.ngrok.io/bank-service/account/get/${accountNumber}`;

export default function BankDetails() {

  // const [accountNumber, setAccountNumber] = useState()
  useEffect(() => {

    axios
    .get(url)
    .then((response) => {
      console.log("get method");
      console.log(response.data);
      console.log("Set bank details");
      setBankDetails({...bankDetails},response.data)
      console.log(setBankDetails);
    });
  })
 

  console.log(bankDetails)

  return (
    <>
      <div className="bg-color">
        <Navbar />
        <Box height={30} />
        <Box sx={{ display: "flex" }}>
          <Sidenav />
          <Box component="main" sx={{ flexGrow: 0.5, p: 3, marginLeft: 20 }}>
            <section className="bankdetails">
              <Grid container direction="row" spacing={3} className="gridbank">
                <Grid item xs="62">
                  <Card className="gridbank">
                    <CardHeader
                      title={
                        <Typography
                          gutterBottom
                          variant="h5"
                          component="h1"
                          sx={{ textAlign: "center", color: "#005555", fontSize: 30, fontWeight: "bold" }}
                        >
                          My bank
                        </Typography>
                      }
                    />
                    <CardContent>
                      <Grid container>
                        <Grid container sx={{ margin: "10px", textAlign: "center", textAlign: "center" }}>
                          <Grid item xs="6">
                            <Typography sx={{ fontSize: 20, paddingTop: 2, fontWeight: "bold", }}>
                              Bank Name
                            </Typography>
                          </Grid>

                          <Grid item xs="6">
                            <Typography
                              gutterBottom
                              variant="h5"
                              component="h1"
                              sx={{ fontSize: 18, paddingTop: 2, color: "black" }}
                            >
                              {bankDetails[0].bankName}
                            </Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px", textAlign: "center" }}>
                          <Grid item xs="6">
                            <Typography sx={{ fontSize: 20, paddingTop: 2, fontWeight: "bold" }}>
                              Account Number
                            </Typography>
                          </Grid>

                          <Grid item xs="6">
                            <Typography
                              gutterBottom
                              variant="h5"
                              component="h1"
                              sx={{ fontSize: 18, paddingTop: 2, color: "black", }}
                            >
                              34567890123
                            </Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                      </Grid>
                      <Grid container>
                        <Grid container sx={{ margin: "10px", textAlign: "center" }}>
                          <Grid item xs="6">
                            <Typography sx={{ fontSize: 20, paddingTop: 2, fontWeight: "bold" }}>
                              Bank Branch
                            </Typography>
                          </Grid>

                          <Grid item xs="6">
                            <Typography
                              gutterBottom
                              variant="h5"
                              component="h1"
                              sx={{ fontSize: 18, paddingTop: 2, color: "black", }}
                            >
                              Chennai
                            </Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px", textAlign: "center" }}>
                          <Grid item xs="6">
                            <Typography sx={{ fontSize: 20, paddingTop: 2, fontWeight: "bold" }}>
                              Account Type
                            </Typography>
                          </Grid>

                          <Grid item xs="6">
                            <Typography
                              gutterBottom
                              variant="h5"
                              component="h1"
                              sx={{ fontSize: 18, paddingTop: 2, color: "black", }}
                            >
                              Savings
                            </Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px", textAlign: "center" }}>
                          <Grid item xs="6">
                            <Typography sx={{ fontSize: 20, paddingTop: 2, fontWeight: "bold" }}>
                              SWIFT Code
                            </Typography>
                          </Grid>

                          <Grid item xs="6">
                            <Typography
                              gutterBottom
                              variant="h5"
                              component="h1"
                              sx={{ fontSize: 18, paddingTop: 2, color: "black", }}
                            >
                              MT101
                            </Typography>
                          </Grid>
                        </Grid>
                        <Grid container sx={{ margin: "10px", textAlign: "center" }}>
                          <Grid item xs="6">
                            <Typography sx={{ fontSize: 20, paddingTop: 2, fontWeight: "bold" }}>
                              Balance
                            </Typography>
                          </Grid>

                          <Grid item xs="6">
                            <Typography
                              gutterBottom
                              variant="h5"
                              component="h1"
                              sx={{ fontSize: 18, paddingTop: 2, color: "black", }}
                            >
                              50000.0
                            </Typography>
                          </Grid>
                        </Grid>
                      </Grid>
                    </CardContent>
                  </Card>
                </Grid>{" "}
              </Grid>{" "}
            </section>
          </Box>
        </Box>
      </div>
    </>
  );
}
