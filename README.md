# KoroveriSpringBoot

This project is backend part of KoronaVerileri project. It benefits from SpringBoot, RESTful API, JUnit, DevTools, Maven, MongoDB, Java and XML. It is prepared on Eclipse IDE and Windows OS and test with Chrome

The frontend side is KoroveriReactive. It provides Reactive Bootstrap 

Link: https://github.com/akinizer/KoroveriReactive

How to run:
  1. Activate MongoDB Server with mongod.exe	
  2. Run KoronaVerileri for backend and RESTful API
	    Through IDE or Command Prompt
  3. Run KoronaReact integrated with CodeRemix Plugin 
	  in Eclipse
	  or with react-scripts start
	  or with npm start
	
  4. The IDE routes you to localhost:3000/CaseModel that is operated by React for frontend

Notes: 
   - Be sure CORS Protocol is disabled on your browser, you can use Chrome Extension "Access-Control-Allow-Origin:ON" if it is necessary)
   - Disable any browser extension with grammar or text checks, that can be incompatible with text formats
   - Start the "temporary" React VIEW through "chrome.exe --user-data-dir="C://Chrome dev session" --disable-web-security" from the directory of chrome.exe
   	-This will avoid CORS for POST methods, that is a policy unfriendly with localhost port transactions and interrupts CRUD operations for database management
   - Fetching operations works asynchroniously. For the performance efficiency, while listing contents, wait for the process to be done. 
   	Otherwise, REACT API will interrupt the CRUD operations as a part of its predefined features   
   
Features:
  - Access to JSON files through browser as a list of records
  - Interactive CRUD operations
  - Filtered search by city and date
  - Unit tests
  - Dynamic Canvas Data Charts
