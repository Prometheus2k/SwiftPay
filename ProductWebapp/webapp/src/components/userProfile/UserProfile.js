import React from 'react';
import "./UserProfile.css"
import { Button, Card, CardContent, CardHeader, CardMedia, Grid, Typography, Box} from '@mui/material';

const UserProfile = () => {
  return (
    <section className='user'>
      <Grid container direction="row" spacing={5}>
        <Grid item xs="12" md="6">
          <Card variant="outlined">
            <CardHeader title="BANK DETAILS" sx={{textAlign: 'center', color: '#005555'}} />
            <CardContent>
              <Grid container>
                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Bank Name</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography>American Express</Typography>
                  </Grid>
                  
                </Grid>

                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>PAN Number</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography >LTIP*****</Typography>
                  </Grid>
                </Grid>
                

                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Account Number</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography >12345678910123</Typography>
                  </Grid>
                </Grid>
                

                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>SwiftCode</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography >MT103*****</Typography>
                  </Grid>
                </Grid>
                

                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Account Type</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography>Business</Typography>
                  </Grid>
                </Grid>
              </Grid>

            </CardContent>
          </Card>
        </Grid>


        <Grid item xs="12" md="6">
          <Card variant='outlined' sx={{padding: '20px'}}>
            <CardMedia
              component="img"
              image="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
              alt="avatar"
              style={{ width: '150px', margin: '0px auto'}}
            />
            <CardHeader title="MY PROFILE" sx={{textAlign: 'center', marginTop: '20px', color: '#005555',}} />
            <CardContent>

              <Grid container direction="row">
                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Full Name</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography >Johnatan Smith</Typography>
                  </Grid>
                </Grid>


                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Email</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography >example@example.com</Typography>
                  </Grid>
                </Grid>


                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Phone</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography>(097) 234-5678</Typography>
                  </Grid>
                </Grid>


                <Grid container sx={{ margin: '10px' }}>
                  <Grid item xs="9">
                    <Typography>Transactions</Typography>
                  </Grid>
                  <Grid item xs="3">
                    <Typography className="text-muted">3</Typography>
                  </Grid>
                </Grid>

              </Grid>

              <Box
                m={1}
                display="flex"
                justifyContent="flex-start"
                alignItems="flex-start"

              >
                <Button variant="contained" sx={{ height: '40px', backgroundColor: '#005555', ":hover": { color: 'white', backgroundColor: '#005555' }, margin: '0px auto' }}>
                  Edit
                </Button>
              </Box>

            </CardContent>

          </Card>
        </Grid>
      </Grid>

    </section >
  );
}

export default UserProfile;
