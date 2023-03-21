import { Box } from "@mui/material";
import React from "react";
import Navbar from "../components/Navbar";
import Sidenav from "../components/Sidenav";

export default function Home() {
  return (
    <>
      <Navbar />
      <Box height={30} />
      <Box sx={{ display: "flex" }}>
        <Sidenav />
        <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
          <h1>Home</h1>
        </Box>
      </Box>
    </>
  );
}
