import * as React from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Paper from "@mui/material/Paper";
import InputAdornment from '@mui/material/InputAdornment';
import Box from "@mui/material/Box";
import MailOutlineIcon from '@mui/icons-material/MailOutline';
import { Card } from "@mui/material";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import KeyIcon from '@mui/icons-material/Key';
import { createTheme, ThemeProvider } from "@mui/material/styles";
import img from "../images/swift_image.jpg";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const theme = createTheme();

export default function Login() {
  const navigate = useNavigate();
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    let mapData = {
      emailId: data.get("email"),
      password: data.get("password"),
    };

    console.log(mapData);

    axios
      .post("http://localhost:8090/user-service/login", mapData)
      .then((res) => {
        if (res.status == 200) {
          console.log(res.data.substring(res.data.indexOf(":")) + 1);
          localStorage.setItem(
            "token",
            res.data.substring(res.data.indexOf(":")) + 1
          );
          navigate("/profile");
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
          overflow: "auto",
          height: "80vh",
          border: "2px solid wheat",
        }}
        sx={{
          my: 8,
          mx: 4,
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
          >
            <img
              src={img}
              style={{
                width: "100%",
                height: "100%",
                objectFit: "cover",
                padding: "20px",
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
                LOGIN
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
                  autoFocus
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
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">
                        <KeyIcon/>
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
                  Login
                </Button>
                <Grid container>
                  <Grid item>
                    <Link href="/signup" variant="body2">
                      {"Don't have an account? Sign Up"}
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
