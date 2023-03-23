import React from "react";
import Navbar from "../components/Navbar";
import Sidenav from "../components/Sidenav";
import "../styles/Userprofile.css";
import {
  Button,
  Card,
  CardContent,
  CardMedia,
  Grid,
  Typography,
  Box
} from "@mui/material";
import { useNavigate } from "react-router-dom";
export default function Userprofile() {

  const navigate = useNavigate();

  return (
    <div className="bg-color">
      <Navbar />
      <Box sx={{ display: "flex" }}>
        <Sidenav />
        <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
          <section className="user">
            <Grid container direction="row" spacing={3}>

              <Grid item xs="12" >
                <Card sx={{ padding: '6vh' }}>
                  <CardMedia
                    component="img"
                    image="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                    alt="avatar"
                    sx={{ width: "170px", margin: "0px auto" }}
                  />
                  <CardContent>

                    <Grid container >
                      <Grid container sx={{ margin: "10px" }}>
                        <Grid item xs="10">
                          <Typography variant="h5">Full Name</Typography>
                        </Grid>
                        <Grid item xs="2">
                          <Typography variant="h6">Johnatan Smith</Typography>
                        </Grid>
                      </Grid>
                      <Grid container sx={{ margin: "10px" }}>
                        <Grid item xs="10">
                          <Typography variant="h5">Email</Typography>
                        </Grid>
                        <Grid item xs="2">
                          <Typography variant="h6">example@example.com</Typography>
                        </Grid>
                      </Grid>
                      <Grid container sx={{ margin: "10px" }}>
                        <Grid item xs="10">
                          <Typography variant="h5">Phone</Typography>
                        </Grid>
                        <Grid item xs="2">
                          <Typography variant="h6">(097) 234-5678</Typography>
                        </Grid>
                      </Grid>
                      <Grid container sx={{ margin: "10px" }}>
                        <Grid item xs="10">
                          <Typography variant="h5">Transactions</Typography>
                        </Grid>
                        <Grid item xs="2">
                          <Typography variant="h6">3</Typography>
                        </Grid>
                      </Grid>
                    </Grid>
                    <Box
                      m={1}
                      display="flex"
                      justifyContent="flex-start"
                      alignItems="flex-start"
                    >
                      <Button onClick={() => navigate("/bank-details")}
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
                        Check Balance
                      </Button>
                    </Box>
                  </CardContent>
                </Card>
              </Grid>
            </Grid>
          </section>
        </Box>
      </Box>
    </div>
  );
}
