function shoppingItem(name, price) {
    this.name = name;
    this.price = price;
}

var shoppingList = new Array();
cartDisplay = document.getElementById("shoppingList");
totalPrice = document.getElementById("totalPrice");


function addToList(name, price) {
    shoppingList.push(new shoppingItem(name, price))
    updateList();
}

function removeLastItem() {
    shoppingList.pop();
    updateList();
}


function updateList() {
    var list = "";
    var total = 0;
    for (var i = 0; i < shoppingList.length; i++) {
        list += "<br>" + shoppingList[i].name + ": $" + shoppingList[i].price.toFixed(2);
        total += shoppingList[i].price;
    }
    cartDisplay.innerHTML = list;
    //console.log(total);
    totalPrice.innerHTML = "Total: $" + total.toFixed(2);
}

function checkOut() {
    return shoppingList;
}
