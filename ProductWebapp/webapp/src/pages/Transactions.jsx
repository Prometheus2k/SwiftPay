import { Box } from "@mui/material";
import React from "react";
import Sidenav from "../components/Sidenav";
import Navbar from "../components/Navbar";
import "../styles/transactionHistory.css";
import axios from "axios";
import { DataGrid, GridToolbar } from "@mui/x-data-grid";
const url = "http://localhost:8060/transaction-service/transaction/history";

export default function Transactions() {
  const columns = [
    {
      field: "receiverSwiftCode",
      headerName: "Transaction Id",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "timeStamp",
      headerName: "Time Stamp",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "message",
      headerName: " Description",
      headerAlign: "center",

      flex: 1,
    },
    {
      field: "receiverAccountNumber",
      headerName: "To Account Number",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "beneficiaryName",
      headerName: "Beneficiary Name",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "accountNumber",
      headerName: "From Account Number",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "credit",
      headerName: "Credit",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "debit",
      headerName: "Debit",
      headerAlign: "center",
      flex: 1,
    },
    {
      field: "status",
      headerName: "Status",
      headerAlign: "center",
      flex: 1,
    },
  ];

  const [rows, setRows] = React.useState([]);

  React.useEffect(() => {
    axios.get(url).then((response) => {
      setRows(response.data);
    });
  }, []);
  console.log(rows);

  return (
    <>
      <div className="bg-color">
        <Navbar />
        <Box height={30} />
        <Box sx={{ display: "flex" }}>
          <Sidenav />
          <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
            <div className="transactionDiv">
              {/* <h1>Transaction History</h1> */}
              <Box
                sx={{ height: " 82vh", width: "100%", alignItems: "center" }}
              >
                <DataGrid
                  sx={{ m: 2, overflowX: "scroll" }}
                  autoHeight
                  rows={rows}
                  columns={columns}
                  getRowId={(row) =>
                    row.receiverSwiftCode +
                    row.timeStamp +
                    row.message +
                    row.receiverAccountNumber +
                    row.beneficiaryName +
                    row.receiverAccountNumber +
                    row.credit +
                    row.debit +
                    row.status
                  }
                  initialState={{
                    pagination: {
                      paginationModel: {
                        pageSize: 5,
                      },
                    },
                  }}
                  pageSizeOptions={[5, 10, 15, 25]}
                  slots={{
                    toolbar: GridToolbar,
                  }}
                />
              </Box>
            </div>
          </Box>
        </Box>
      </div>
    </>
  );
}
