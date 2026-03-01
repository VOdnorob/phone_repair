import React, {useState} from 'react';

export default function Client() {
    const [responseStatus, setResponseStatus] = useState(null);
    const [user, setUser] = useState(
        {
            name: "",
            surname: "",
            email: "",
            password: "",
            numberPhone: ""
        });


    async function addUser() {
        try {
            const response = await fetch(
                "http://localhost:8080/user/registration",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(user)
                }
            );
            setResponseStatus(response.status === 201 ? "User added successfully" : "Failed to add user");
        }catch (error) {
        console.log(error);}
    }



    return (

        <div>
            <label>
                Name: <input name="name"
                             value={user.name}
                             onChange={e => setUser({...user, name: e.target.value})}/>
                <hr/>
                Surname: <input name="surname"
                                value={user.surname}
                                onChange={e => setUser({...user, surname: e.target.value})}/>
                <hr/>
                Email: <input name="email"
                              value={user.email}
                              onChange={e => setUser({...user, email: e.target.value})}/>
                <hr/>
                Password: <input name="password"
                                 value={user.password}
                                 onChange={e => setUser({...user, password: e.target.value})}/>
                <hr/>
                Phone Number: <input name="phoneNumber"
                                     value={user.numberPhone}
                                     onChange={e => setUser({...user, numberPhone: e.target.value})}/>
                <hr/>
            </label>
            <button onClick={addUser}> Registration user</button>
        </div>
    );
}