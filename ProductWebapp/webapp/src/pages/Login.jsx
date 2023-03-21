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
import { useNavigate } from "react-router-dom";

const theme = createTheme();

export default function Login() {
  const navigate = useNavigate();
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
      email: data.get("email"),
      password: data.get("password"),
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
          // sx={{
          //   backgroundImage: `url(${img})`,
          //   backgroundPosition: 'center',
          //   maxWidth: '200px'
          // }}
        >
          <img
            src={img}
            style={{ width: "100%", height: "100%", objectFit: "cover" }}
          />
        </Grid>
        <Grid item xs={12} sm={12} md={12} lg={6} component={Paper} square>
          <Box
            style={{ marginTop: "200px", padding: "100px" }}
            sx={{
              my: 8,
              mx: 4,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
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
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
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
    </ThemeProvider>
  );
}
