import React, { useState, useEffect } from "react";
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
<<<<<<< HEAD
  Box
=======
  Box,
>>>>>>> 5cddc4ed794ed926d7e329796291edaf28f541db
} from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
export default function Userprofile() {
  const [data, SetData] = useState([]);

  const navigate = useNavigate();
  let userData;
  let email = localStorage.getItem("email");

  useEffect(() => {
    axios
      .get(`http://localhost:8090/user-service/users/${email}`)
      .then((res) => {
        console.log(res.data);
        SetData(res.data);
      })
      .catch(function (error) {
        console.log(error.response.data);
      });
  }, []);

  console.log(data.emailId);
  return (
    <div className="bg-color">
      <Navbar />
      <Box sx={{ display: "flex" }}>
        <Sidenav />
        <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
          <section className="user">
            <Grid container direction="row" spacing={3}>
              <h1>{localStorage.getItem("email")}</h1>
              <Grid item xs="12">
                <Card sx={{ padding: "6vh" }}>
                  <CardMedia
                    component="img"
                    image="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                    alt="avatar"
                    sx={{
                      maxWidth: "170px",
                      margin: "0px auto",
                      borderRadius: "100%",
                      borderColor: "grey.500 ",
                    }}
                  />
                  <CardContent>
                    

<<<<<<< HEAD
                    <Grid container spacing={3}>
                      <Grid container sx={{ margin: "1%" }}>
                        <Grid item xs="9">
                          <Typography variant="h5" sx={{ fontFamily: 'sans-serif' }}>Name</Typography>
                        </Grid>
                        <Grid item xs="3">
                          <Typography variant="h6" sx={{ fontFamily: 'sans-serif' }}>Johnatan Smith</Typography>
                        </Grid>
                      </Grid>
                      <Grid container sx={{ margin: "1%" }}>
                        <Grid item xs="9">
                          <Typography variant="h5" sx={{ fontFamily: 'sans-serif' }}>Email</Typography>
                        </Grid>
                        <Grid item xs="3">
                          <Typography variant="h6" sx={{ fontFamily: 'sans-serif' }}>example@example.com</Typography>
                        </Grid>
                      </Grid>
                      <Grid container sx={{ margin: "1%" }}>
                        <Grid item xs="9">
                          <Typography variant="h5" sx={{ fontFamily: 'sans-serif' }}>Phone</Typography>
                        </Grid>
                        <Grid item xs="3">
                          <Typography variant="h6" sx={{ fontFamily: 'sans-serif' }}>(097) 234-5678</Typography>
                        </Grid>
                      </Grid>
                      <Grid container sx={{ margin: "1%" }}>
                        <Grid item xs="9">
                          <Typography variant="h5" sx={{ fontFamily: 'sans-serif' }}>Location</Typography>
                        </Grid>
                        <Grid item xs="3">
                          <Typography variant="h6" sx={{ fontFamily: 'sans-serif' }}>India</Typography>
                        </Grid>
                      </Grid>
                    </Grid>

=======
>>>>>>> 5cddc4ed794ed926d7e329796291edaf28f541db
                    <Box
                      m={1}
                      display="flex"
                      justifyContent="flex-start"
                      alignItems="flex-start"
                    >
                      <Button
                        onClick={() => navigate("/bank-details")}
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
