`use strict`;

// <-- Retrieve all Team Members -->
function retrieveScores() {

    axios.get(`http://localhost:9001/person/findAll`, {
        headers: {
            "Access-Control-Allow-Origin": '*',
        }
    })
        .then((response) => displayUserDetails(response.data))
        .catch((error) => console.log(`Retrieve team members failed ${error}`));
}

function displayUserDetails(data) {
    data.forEach(function (value, i) {
        document.getElementById(`table`).innerHTML += `<tr>
        <td>${data[i].firstName}</td>
        <td>${data[i].lastName}</td>
        <td>${data[i].score>=70 ? "pass" : "fail"}</td>
        </tr>`;
    })
    console.log(data);
}

// Retrieve team details
retrieveScores();

