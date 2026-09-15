document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const formData = {
        name: document.getElementById('fullname').value,
        email: document.getElementById('email').value
    };
    
    try {
        const response = await fetch('/employee/create',{
            method: 'POST',
            headers: {
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify(formData)
        });
        if (response.ok){
            alert("Login Successful");
            console.log("Success:", await response.json());
        }
        else {
            alert("Error");
        }
    }
    catch(error) {
        console.error("Error: ", error)
    }
});