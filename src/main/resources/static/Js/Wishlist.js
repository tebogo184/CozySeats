
const container= document.getElementById('container');
const registerNavLink=document.getElementById("registerNavLink");
const loginNavLink=document.getElementById("loginNavLink");

loginNavLink.addEventListener("click",()=>{

    document.getElementById("login-box").classList.remove("hidden");
});

registerNavLink.addEventListener("click",()=>{

    document.getElementById("register-box").classList.remove("hidden");
});

document.addEventListener('DOMContentLoaded',()=>{

    displayWishlist();
});


const displayWishlist=()=>{
    const wishlist=JSON.parse(sessionStorage.getItem('wishlist'));


    if(!wishlist||wishlist.length<0){

        sessionStorage.removeItem('wishlist');
        return ;
        
    }

    wishlist.forEach(product => {
        
        const {productID,name,price,quantity,description,imgSrc}=product;
        const productBox=document.createElement('div');

        productBox.className=` mt-4 flex flex-row `;
        productBox.innerHTML=`
        <div class=' flex justify-center items-center custom-border'><img class='' src='../images/${imgSrc}' alt='${name}'></div>
        <div class='flex flex-col  justify-center ml-5 mr-5'>
        <div>${name}</div>
        <div class='mt-4'>${description}</div>
        <div class='font-bold text-xl mt-4'>R ${price}</div>
        </div>
        <div class='flex flex-row  justify-center items-center ml-5'>
        <button id=${productID} class='cartBtn bg-green-700 rounded-md  h-4 w-48'>Add to Cart</button>
        <button id=${productID}  class='deleteBtn  flex justify-center ml-5 items-center cursor-pointer' ><i class="bi bi-trash3-fill"></i></button>
        </div>
        `

        container.append(productBox);

        deleteEventListner();
        addCartEventListner();
        
    
    });
    

}

const addToCart= async (cartItem,userID)=>{


    try {
        
        const response=await fetch(`http://localhost:8080/addCartItem/${userID}`,{

            headers:{
                "Content-Type":"application/json"
            },
            method:"POST",
            body: JSON.stringify(cartItem)
        });

        if(!response.ok){

            throw new error("Failed to add item to the cart");
        }

        const data =await response.json();
        console.log(data)
        sessionStorage.removeItem("cartItems");
        sessionStorage.setItem("cartItems",JSON.stringify(data));
        console.log("Item has been added Succesful");
        console.log(sessionStorage);

    } catch (error) {
        
        console.log(error);
    }

}
const addCartEventListner=()=>{

    const cartButtons=document.querySelectorAll(".cartBtn");

    cartButtons.forEach(button=>{

        button.addEventListener('click',()=>{
            
            const prodID= button.id;

            const userID=sessionStorage.getItem("userID");

            const cartItem=
            {

                productID:prodID,
                cartID:"",
                quantity:1

            }

            addToCart(cartItem,userID);


        });

    });
}
const deleteEventListner=()=>{
    const deleteButtons=document.querySelectorAll('.deleteBtn');

    deleteButtons.forEach(button=>{

        button.addEventListener('click',()=>{

            const id= button.id;
            const wishlist=JSON.parse(sessionStorage.getItem('wishlist'));

        const newWishlist=  wishlist.filter(prod=> prod.productID!=id);
        sessionStorage.setItem('wishlist',JSON.stringify(newWishlist));
        location.reload();
        });
    });
}