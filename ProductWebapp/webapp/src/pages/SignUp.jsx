import * as React from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import img from "../images/swift_image.jpg";
import { MuiTelInput } from "mui-tel-input";
import axios from "axios";
<<<<<<< HEAD
import { Card } from '@mui/material';
=======
>>>>>>> 04e7d471166f0e938b9b1b4eeb300b8d0b0b6f59
import { useNavigate } from "react-router-dom";
const theme = createTheme();
export default function SignUp() {
  const navigate = useNavigate();
  const [value, setValue] = React.useState("");
  const handleChange = (newValue) => {
    setValue(newValue);
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    let mapData = {
      emailId: data.get("email"),
      password: data.get("password"),
      nameOfTheUser: data.get("name"),
      mobileNumber: value,
      location: null,
      panNumber: null,
      profilePassword: null,
    };
    console.log(mapData);
    axios
      .post(
        "https://e648-115-111-183-90.in.ngrok.io/user-service/register",
        mapData
      )
      .then((res) => {
        if (res.status == 201) {
          navigate("/");
        }
        localStorage.setItem("email", mapData.emailId);
      })
      .catch(function (error) {
        console.log(error.response.data);
      });
  };
  return (
    <ThemeProvider theme={theme}>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={false}
          md={false}
          lg={6}
          style={{ padding: "20vh" }}
<<<<<<< HEAD
        // sx={{
        //   backgroundImage: `url(${img})`,
        //   backgroundPosition: 'center',
        //   maxWidth: '200px'
        // }}
=======
          // sx={{
          //   backgroundImage: `url(${img})`,
          //   backgroundPosition: 'center',
          //   maxWidth: '200px'
          // }}
>>>>>>> 04e7d471166f0e938b9b1b4eeb300b8d0b0b6f59
        >
          <img
            src={img}
            style={{ width: "100%", height: "100%", objectFit: "cover" }}
          />
        </Grid>
<<<<<<< HEAD
        <Grid item xs={12} sm={12} md={12} lg={6} square>
          <Card style={{ padding: "100px", borderTop:"2px solid white" ,boxShadow:"1px 1px 1px 1px "}}
=======
        <Grid item xs={12} sm={12} md={12} lg={6} component={Paper} square>
          <Box
            style={{ padding: "100px" }}
>>>>>>> 04e7d471166f0e938b9b1b4eeb300b8d0b0b6f59
            sx={{
              my: 8,
              mx: 4,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
<<<<<<< HEAD
              
            }}>
          <Box
           
            
=======
            }}
>>>>>>> 04e7d471166f0e938b9b1b4eeb300b8d0b0b6f59
          >
            <Typography component="h1" variant="h4">
              SIGN UP
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit}
              sx={{ mt: 1 }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                id="name"
                label="Name"
                name="name"
                autoComplete="name"
              />
              <MuiTelInput
                margin="normal"
                id="phone"
                placeholder="Phone"
                required
                value={value}
                onChange={handleChange}
                fullWidth
                sx={{ paddingTop: 1 }}
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2, height: 50 }}
                style={{ backgroundColor: "#005555" }}
              >
                Sign Up
              </Button>
              <Grid container>
                <Grid item>
                  <Link href="/login" variant="body2">
                    {"Already have an account ? Login "}
                  </Link>
                </Grid>
              </Grid>
            </Box>
            
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}