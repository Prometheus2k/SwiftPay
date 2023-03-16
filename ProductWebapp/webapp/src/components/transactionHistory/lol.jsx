import { DataGrid } from "@mui/x-data-grid";
import React from "react";




function Lol() {

    function createData(transactionId, timeStamp, description, fromAccountNumber, toAccountNumber, amount, status) {
        return { transactionId, timeStamp, description, fromAccountNumber, toAccountNumber, amount, status };
    }
    const rows = [
        createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 6000, 'fail'),
        createData('2321345341132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 104500, 'success'),
        createData('232134s2132132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 10040, 'success'),
        createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 100230, 'success'),
        createData('2123434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 100330, 'success'),
        createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
        createData('34341434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
        createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    ];
    return (
        <DataGrid
            columns={[{ field: 'Transaction ID', width: 200, flex: 1 },
            { field: 'TimeStamp', width: 200, flex: 1 },
            { field: 'Description', width: 200, flex: 1 },
            { field: 'To Account Number', width: 200, flex: 1 },
            { field: 'Amount', width: 200, flex: 1 },
            { field: 'Status', width: 200, flex: 1 }

            ]}
            rows={rows}
        />


    )
}

export default Lol