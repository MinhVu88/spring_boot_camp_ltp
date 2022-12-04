import React, {useState, useEffect} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

const App = () => {
	const [grades, setGrades] = useState([]);

	useEffect(() => {
		fetch('http://localhost:8080/grades')
      .then(response => response.json())
      .then(data =>  setGrades(data));
	}, []);

	console.log(grades);

	return (
		grades.length > 0 
		? grades.map(({id, name, subject, score}) => 
			<div key={id}>
				<div className="container">
					<table id="table">
						<thead>
							<tr>
								<th>Student</th>
								<th>Subject</th>
								<th>Score</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>{name}</td>
								<td>{subject}</td>
								<td>{score}</td>
							</tr>
						</tbody>
					</table>        
				</div>
    	</div>
		) : <h1 style={{textAlign: 'center', margin: '300px auto'}}>Data Not Found</h1>
	)
}


ReactDOM.createRoot(document.getElementById('root'))
				.render(
					<React.StrictMode>
						<App />
					</React.StrictMode>
				);
