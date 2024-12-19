


const submmitBtn = document.getElementById("submitBtn");
const closeBtn = document.getElementById("closeBtn");
const close = document.getElementById("close");

const productsContainer = document.getElementById("products-container");
const registerBtn=document.getElementById("registerBtn");
const registerNavLink=document.getElementById("registerNavLink");
const loginNavLink=document.getElementById("loginNavLink");

loginNavLink.addEventListener("click",()=>{

    document.getElementById("login-box").classList.remove("hidden");
    document.getElementById("register-box").classList.add("hidden");


});

registerNavLink.addEventListener("click",()=>{

    document.getElementById("register-box").classList.remove("hidden");
    document.getElementById("login-box").classList.add("hidden");

});

close.addEventListener('click',()=>{

    console.log("click in the close section");
    document.getElementById('register-box').classList.add("hidden");

});
closeBtn.addEventListener('click', () => {

    console.log("clicked");
    document.getElementById("login-box").classList.add("hidden");
})

registerBtn.addEventListener('click',(e)=>{


    e.preventDefault();
    const firstName=document.getElementById("firstName").value;
    const surname=document.getElementById("surname").value;
    const password=document.getElementById("RegisterPassword").value;
    const email=document.getElementById("RegisterEmail").value;

    const submitForm= async ()=>{

        try {
            const response=await fetch("http://localhost:8080/register",{

                headers:{
                    "Content-Type":"application/json"
                },
                method:"POST",
                body:JSON.stringify({firstName,surname,password,email})
            })
    
            console.log(response);
            if(!response.ok){
                console.log("Failed to register user")
                throw new error("Failed to register user");
    
            }
    
            const data=await response.json();
    
            console.log(data);
            sessionStorage.setItem("userID",JSON.stringify(data.userID));
            document.getElementById('register-box').classList.add("hidden");
            ///location.reload();

        } catch (error) {
            console.log(error);
        }


    }

    submitForm();
})
submmitBtn.addEventListener('click', (e) => {

    e.preventDefault();
    const password = document.getElementById("password").value;
    const email = document.getElementById("email").value;


    const submitForm = async () => {

        
        try {

            const response = await fetch("http://localhost:8080/login", {

                headers: {
                    'Content-Type': 'application/json'
                },
                method: 'POST',
                body: JSON.stringify({ email, password })

            });


            console.log(response);
            if (!response.ok) {
                document.getElementById("errorLabel").classList.remove("hidden");
                console.log("could not log in");
                throw new error("Could not log in");
            } else {
                document.getElementById('login-box').classList.add("hidden");
                console.log("Succesful");
            }
            const data = await response.json();
            console.log(data);
            sessionStorage.setItem("userID",JSON.stringify(data.userID));
            console.log("User has just logged in:"+data.userID);
            document.dispatchEvent(new Event('DOMContentLoaded'));



        } catch (error) {

            console.log(error);
        }
    }

    submitForm();
})

//Used to display all the available products in the home page
document.addEventListener('DOMContentLoaded', () => {

    if (!sessionStorage.getItem('products')) {

        fetch("http://localhost:8080/allProducts", {})
            .then(response => {
                if (!response.ok) {
                    throw new error("Could not fetch all the data");
                }
                return response.json();
            })
            .then(data => {
                sessionStorage.setItem('products', JSON.stringify(data));
                displayAllProducts(data)
            })
            .catch(error => {
                console.log(error);
            });


    } else {
        const products = JSON.parse(sessionStorage.getItem('products'));

        displayAllProducts(products);
    }

});

const getAllProducts = () => {




}
const displayAllProducts = (products) => {

    products.forEach(product => {

        const { productID, name, price, imgSrc } = product;
        const productBox = document.createElement('div');

        //Product Box that will store a unique product and its details
        productBox.id = productID;
        productBox.className = ' flex flex-col justify-center items-center ';

        productBox.innerHTML = `
        <a href='AboutProduct.html?id=${productID}'>
        <img src='../images/${imgSrc}' alt='${name}'>
        </a>
        <div>${name}</div>
        <div class='flex flex-row gap-4'>
         <div>R ${price}</div>
         <button type='submit' id=${productID} class='wishlistBtn' ><i class="bi bi-heart " ></i></button>
         </div>
        `;

        productsContainer.append(productBox);



    });

    addWishlistEventListener();
}



 const addWishlistEventListener=()=>{

    const wishlistButtons=document.querySelectorAll('.wishlistBtn');

    wishlistButtons.forEach(button=>{

        button.addEventListener('click',()=>{

            const prodID=button.id;
            console.group(prodID);

            addProductToWishlist(prodID);

    
        });
    });

 }

 const addProductToWishlist=(prodID)=>{

    const productList=JSON.parse(sessionStorage.getItem('products'));
    const product=productList.find(prod=> prod.productID==prodID);

    if(sessionStorage.getItem('wishlist')){
        const wishlist=JSON.parse(sessionStorage.getItem('wishlist'));

        if(!wishlist.find(prod=>prod.productID==prodID)){

            wishlist.push(product);

        }

    sessionStorage.setItem('wishlist',JSON.stringify(wishlist));
    
    console.log(wishlist)

    }else{

        const wishlist=[];

        wishlist.push(product);

        sessionStorage.setItem('wishlist',JSON.stringify(wishlist));
        console.log("new wishlist created");
        console.log(wishlist);
    }

 }