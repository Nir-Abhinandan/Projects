import nltk.sentiment
nltk.download('vader_lexicon') #This is the file where all words get a value to determine wether its happy or sad.
analyzer = nltk.sentiment.SentimentIntensityAnalyzer()



def get_sentiment(user_input):
    
    scores = analyzer.polarity_scores(user_input)
    
    sentiment_score = scores['compound']
    
    return sentiment_score



def get_reaction(score):
    
    if score > 0.5:
        return "😀"
    if score > 0:
        return "🙂"
    if score == 0:
       return "😐"
    if score < -0.5:
        return "😢"
    if score < 0:
        return "😞"
    
#This is where everything happens to create the bot

def main():
    while True:
        user_input = input('what do you want to say?: ') 
        score = get_sentiment(user_input)
        reaction = get_reaction(score)
        print(reaction)
        print(score)
        print('________')
        
if __name__ == "__main__":
    main()
    
