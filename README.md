# Java Assignment

### this project is running on port: 5000

#### POST API= http://localhost:5000/tci/employee-bonus
##Dummy data:
[
		{
			"empName": "raj singh",
			"department": "accounts",
			"amount": 5000,
			"currency": "INR",
			"joiningDate": "May-20-2022",
			"exitDate": "May-20-2023"
		},
		{
			"empName": "pratap m",
			"department": "accounts",
			"amount": 3000,
			"currency": "INR",
			"joiningDate": "Jan-01-2021",
			"exitDate": "May-20-2023"
		},
		{
			"empName": "sushmita lal",
			"department": "IT",
			"amount": 4000,
			"currency": "INR",
			"joiningDate": "Jan-01-2021",
			"exitDate": "Dec-31-2021"
		},
		{
			"empName": "sam",
			"department": "Operations",
			"amount": 2500,
			"currency": "USD",
			"joiningDate": "May-20-2022",
			"exitDate": "May-20-2023"
		},
		{
			"empName": "john",
			"department": "Operations",
			"amount": 2500,
			"currency": "USD",
			"joiningDate": "Jan-20-2023",
			"exitDate": "Dec-30-2024"
		},
		{
			"empName": "susan",
			"department": "IT",
			"amount": 700,
			"currency": "USD",
			"joiningDate": "Jan-01-2022",
			"exitDate": "Dec-31-2022"
		}
	]

### GET API=http://localhost:5000/tci/employee-bonus?date=May-20-2022
#### Output:

{
  "errorMessage": "",
  "data":[
    {
      "currency": "USD",
      "employees":[
            {"empName": "sam", "amount": 2500.0},
            {"empName": "susan", "amount": 700.0}
        ]
    },
    {
      "currency": "INR",
      "employees":[
            {"empName": "raj singh", "amount": 5000.0},
            {"empName": "pratap m", "amount": 3000.0}
        ]
    }
    ]
  }
