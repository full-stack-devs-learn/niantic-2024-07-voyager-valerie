class ShoppingService {

    getListName() {
        return 'SHOPPING LIST';
    }

    getShoppingList() {
        return [
            {
                id: 1,
                title: '5 lb sack of potatoes',
                quantity: 1,
                isComplete: false
            },
            {
                id: 2,
                title: 'Frozen Pizza',
                quantity: 4,
                isComplete: true
            },
            {
                id: 3,
                title: 'Hash Brown',
                quantity: 2,
                isComplete: false
            },
            {
                id: 4,
                title: 'Frozen Vegetables',
                quantity: 1,
                isComplete: true
            },
            {
                id: 5,
                title: 'Xiao Long Bao',
                quantity: 3,
                isComplete: false
            },
            {
                id: 6,
                title: 'Ice Cream',
                quantity: 1,
                isComplete: false
            },
            {
                id: 7,
                title: 'Pot Sticker',
                quantity: 2,
                isComplete: true
            },
            {
                id: 8,
                title: 'Popsicle',
                quantity: 3,
                isComplete: true
            },
            {
                id: 9,
                title: 'Shu Mai',
                quantity: 5,
                isComplete: true
            },
            {
                id: 10,
                title: 'Wonton',
                quantity: 15,
                isComplete: false
            }
        ];
    }
}