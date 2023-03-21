import React from "react";
import Navbar from "../components/Navbar";
import Sidenav from "../components/Sidenav";
import "../styles/Userprofile.css";
import {
  Button,
  Card,
  CardContent,
  CardHeader,
  CardMedia,
  Grid,
  Typography,
  Box,
  Divider,
} from "@mui/material";
export default function Userprofile() {
  return (
    <>
      <div className="bg-color">
        <Navbar />
        <Box height={30} />
        <Box sx={{ display: "flex" }}>
          <Sidenav />
          <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
            <section className="user">
              <Grid container direction="row" spacing={3}>
                <Grid item xs="6">
                  <Card>
                    <CardHeader>Bank Details</CardHeader>
                    <CardContent>
                      <Grid container>
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Bank Name</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>American Express</Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>PAN Number</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>LTIP*****</Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Account Number</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>12345678910123</Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>SwiftCode</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>MT103*****</Typography>
                          </Grid>
                        </Grid>
                        <Divider />{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Account Type</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>Business</Typography>
                          </Grid>
                        </Grid>
                      </Grid>{" "}
                    </CardContent>
                  </Card>
                </Grid>{" "}
                <Grid item xs="6">
                  <Card>
                    <CardHeader sx={{ color: "black" }}>My Profile</CardHeader>
                    <CardMedia
                      component="img"
                      image="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                      alt="avatar"
                      style={{ width: "150px", margin: "0px auto" }}
                    />
                    <CardContent>
                      {" "}
                      <Grid container direction="row">
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Full Name</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>Johnatan Smith</Typography>
                          </Grid>
                        </Grid>{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Email</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>example@example.com</Typography>
                          </Grid>
                        </Grid>{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Phone</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography>(097) 234-5678</Typography>
                          </Grid>
                        </Grid>{" "}
                        <Grid container sx={{ margin: "10px" }}>
                          <Grid item xs="6">
                            <Typography>Transactions</Typography>
                          </Grid>
                          <Grid item xs="6">
                            <Typography className="text-muted">3</Typography>
                          </Grid>
                        </Grid>{" "}
                      </Grid>{" "}
                      <Box
                        m={1}
                        display="flex"
                        justifyContent="flex-start"
                        alignItems="flex-start"
                      >
                        <Button
                          variant="contained"
                          sx={{
                            height: 40,
                            backgroundColor: "#005555",
                            ":hover": {
                              color: "white",
                              backgroundColor: "#005555",
                            },
                            margin: "0px auto",
                          }}
                        >
                          Edit
                        </Button>
                      </Box>{" "}
                    </CardContent>{" "}
                  </Card>
                </Grid>
              </Grid>{" "}
            </section>
          </Box>
        </Box>
      </div>
    </>
  );
}
