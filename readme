# BANK API

## HOW TO RUN
-> Clone the project, then in the command line you can run the command 'gradle bootRun'
-> Or you can open it in your java code editor and run it from there.

## ABOUT

This code is divided in three parts: the Checking Account, the Bank Posting and the Transactions between them.

Checking Account -> The Checking Account is an entity that contains the main properties that are needed in this context: the name of the owner, the social number (equal to cpf in Brazil) and the total savings (total cash that he has now). The account can be only updated, for security purposes.

BankPosting -> This entity has the historic of transactions made by accounts. Here are saved the ids of the accounts, the data the transaction occurred and the value.

Transfer -> This is where the transactions are made: this method receives the ids of the accounts and the value that is to be transferred. Then, the some verifications are made to make sure that the transfer is made successfully, like:
- The origin account and the recipient account cannot be the same
- The origin account must have the value in it's account
- The value must not be negative or 0

After the verifications, the amount is decreased from origin account, added in recipient account and the bank posting is created and can be viewed.

## AVAILABLE ENDPOINTS

Transfer:
/transfer -> to make a transfer. Params => originAccount, recipientAccountId, transferValue

Checking Account:
/accounts/all -> to see all the checking accounts on database. Params => No params
/accounts/account/id -> to search for a checking account by id. Params => id (integer)
/accounts/account/social-number -> to search for a checking account by social number. Params => socialNumber (String)
/accounts/account/update -> to update one checking account. Params => checkingAccountEntity

Bank Posting:
/bank-posting/all -> to see all bank postings. Params => No params
/bank-posting/id -> to search for a bank posting by id. Params => id (integer)
/bank-posting/origin-account -> to search for a bank posting by origin account. Params => originAccount (integer)
/bank-posting/recipient-account -> to search for a bank posting by recipient account. Params => recipientAccount (integer)
/bank-posting/update -> to update a bank posting. Params => bankPostingEntity
/bank-posting/create -> to create a bank posting. Params => bankPostingEntity

## CheckingAccountEntity

{
    id: Integer,
    firstName: String,
    lastName: String,
    socialNumber: String,
    totalSavings: String
}

## BankPostingEntity

{
    postingId: Integer,
    postingDate: LocalDate,
    originAccount: Integer,
    recipientAccount: Integer,
    totalValue: Integer
}

## WHAT COULD BE BETTER (AND WHAT I WANT FOR A V2)
-> I could have done the tests in a better way, tested more of error cases
-> I want to make this is microservices style, with all components talking with each other between REST endpoints, and not by calls made directly by it's services.
-> Implement more verifications (based on a real bank service) on transfer.
-> Implement the bank posting better (with more knowledge of a bank)
-> Put more attributes on checking account
-> Implement a safer endpoint call (with auth and tokens)
