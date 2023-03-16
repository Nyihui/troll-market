select * from TransactionTroll as tra
left outer join Account as acc on tra.BuyerUsername = acc.Username
left outer join Merchandise as mer on tra.MerchandiseId = mer.Id
left outer join Account as accSeller on mer.SellerUsername = accSeller.Username