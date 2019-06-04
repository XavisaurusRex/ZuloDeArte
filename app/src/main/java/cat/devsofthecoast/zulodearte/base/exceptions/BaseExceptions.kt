package cat.devsofthecoast.zulodearte.base.exceptions

class InvalidViewTypeException : Exception("View type especified invalid")
class NotValidApiResponse(apiResource: String) : Exception("Failed to retrieve or parse data of $apiResource")