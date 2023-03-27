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
import KeyIcon from "@mui/icons-material/Key";
import img from "../images/swift_image.jpg";
import { MuiTelInput } from "mui-tel-input";
import axios from "axios";
import { Card, InputAdornment } from "@mui/material";
import { useNavigate } from "react-router-dom";
import DriveFileRenameOutlineIcon from "@mui/icons-material/DriveFileRenameOutline";
import { style } from "@mui/system";
import LocationOnIcon from '@mui/icons-material/LocationOn';
import MailOutlineIcon from "@mui/icons-material/MailOutline";
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
      location: data.get("location"),
      panNumber: null,
      profilePassword: null,
    };
    console.log(mapData);
    axios
      .post("http://localhost:8090/user-service/register", mapData)
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
      <Card
        style={{
          padding: "100px",
          height: "80vh",
          
          borderColor: "black",
          border: "2px solid grey",
        }}
        sx={{
          my: 8,
          mx: 26,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Grid container component="main" sx={{ height: "100vh" }}>
          <CssBaseline />
          <Grid
            item
            xs={false}
            sm={false}
            md={false}
            lg={6}

            // sx={{
            //   backgroundImage: `url(${img})`,
            //   backgroundPosition: 'center',
            //   maxWidth: '200px'
            // }}
            // sx={{
            //   backgroundImage: `url(${img})`,
            //   backgroundPosition: 'center',
            //   maxWidth: '200px'
            // }}
          >
            <img
              src={img}
              style={{
                width: "100%",
                height: "100%",
                objectFit: "cover",
                padding: "5px"
              }}
            />
          </Grid>
          <Grid
            item
            xs={12}
            sm={12}
            md={12}
            lg={6}
            square
            style={{ padding: "50px" }}
          >
            <Box>
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
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">
                        <MailOutlineIcon />
                      </InputAdornment>
                    ),
                  }}
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
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">
                        <KeyIcon />
                      </InputAdornment>
                    ),
                  }}
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="name"
                  label="Name"
                  name="name"
                  autoComplete="name"
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">
                        <DriveFileRenameOutlineIcon />
                      </InputAdornment>
                    ),
                  }}
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

                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="location"
                  label="Location"
                  name="location"
                  autoComplete="location"
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">
                        <LocationOnIcon />
                      </InputAdornment>
                    ),
                  }}
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
                    <Link href="/" variant="body2">
                      {"Already have an account ? Login "}
                    </Link>
                  </Grid>
                </Grid>
              </Box>
            </Box>
          </Grid>
        </Grid>
      </Card>
    </ThemeProvider>
  );
}
