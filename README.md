# Employee Database Management System

## Description
A Java command-line application for managing employee records using 
file-based storage. Supports adding new employee records and modifying 
existing ones, with all data persisted to a text file.

## Features
- Add up to 3 employee records (name, age, monthly salary)
- Modify any employee's salary by searching by name
- Persists all data to `Employee_Record.txt`
- Uses a temp file strategy to safely update records without data loss
- Supports multiple modifications in a single session

## How It Works
1. Prompts user to enter 3 employee records (name, age, salary)
2. Appends records to `Employee_Record.txt`
3. To modify: searches file line by line for matching employee name
4. Copies all records to `temp.txt`, updating the matched record
5. Deletes old file and renames `temp.txt` to `Employee_Record.txt`
6. Repeats until user chooses to stop

## Technologies Used
- Java
- File I/O (`FileOutputStream`, `PrintStream`, `Scanner`)
- File manipulation (create, delete, rename)
- String parsing and record management

## How to Run
1. Clone the repository
2. Compile: `javac EmpDatabase.java`
3. Run: `java EmpDatabase`
4. Follow the prompts to add and modify employee records

## What I Learned
- File I/O and persistent data storage in Java
- Safe file update patterns using temporary files
- String parsing and record manipulation
- Building a basic CRUD system without a database
